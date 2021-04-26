package com.cpprates.test.dataanalysissystem.app;

import com.cpprates.test.dataanalysissystem.service.AnalysisService;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class App {
    public static void main(String[] args) {
        File file = new File("./src/main/java/data/in/");
        try {
            System.out.println("Listening on: " + file);
            listenForChanges(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void listenForChanges(File file) throws IOException {
        Path path = file.toPath();
        if (file.isDirectory()) {
            WatchService ws = path.getFileSystem().newWatchService();
            path.register(ws, StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
            WatchKey watch = null;
            while (true) {
                System.out.println("Watching directory: " + file.getPath());
                try {
                    watch = ws.take();
                } catch (InterruptedException ex) {
                    System.err.println("Interrupted");
                }
                List<WatchEvent<?>> events = watch.pollEvents();
                watch.reset();
                for (WatchEvent<?> event : events) {
                    WatchEvent.Kind<Path> kind = (WatchEvent.Kind<Path>) event.kind();
                    Path context = (Path) event.context();
                    if (kind.equals(StandardWatchEventKinds.OVERFLOW)) {
                        System.out.println("OVERFLOW");
                    } else if (kind.equals(StandardWatchEventKinds.ENTRY_CREATE)) {
                        System.out.println("Created: " + context.getFileName());
                        AnalysisService service = new AnalysisService();
                        service.readFile(context.getFileName().toString());
                        service.writeFile();
                    } else if (kind.equals(StandardWatchEventKinds.ENTRY_DELETE)) {
                        System.out.println("Deleted: " + context.getFileName());
                    } else if (kind.equals(StandardWatchEventKinds.ENTRY_MODIFY)) {
                        System.out.println("Modified: " + context.getFileName());
                    }
                }
            }
        } else {
            System.err.println("Not a directory. Will exit.");
        }
    }
}

package nl.remco.novi.backend.eindopdracht.into_art;

import nl.remco.novi.backend.eindopdracht.into_art.consoleApp.IntoArtConsoleApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntoArtApplication {

    public static void main(String[] args) {

        SpringApplication.run(IntoArtApplication.class, args);

        new IntoArtConsoleApp()
                .runIntoArtConsoleApp();


//            String parentPath = "C:\\Users\\Public\\Documents\\into_art";
//            String childPath = "test.json";
//            var path = Paths.get(parentPath).resolve(childPath);
//            System.out.format("getFileName: %s%n", path.getFileName());
//            System.out.format("getNameCount: %d%n", path.getNameCount());
//            System.out.format("getParent: %s%n", path.getParent());
//
//            System.out.println("path = " + path);
//            System.err.format(String.valueOf(path));

//            try {
//                path.toRealPath();
//            } catch (NoSuchFileException x) {
//                System.err.format("%s: no such file" + " or directory%n", path);
//                // Logic for case when file doesn't exist.
//            } catch (IOException x) {
//                System.err.format("%s%n", x);
//            }

//            try (var fc = FileChannel.open(path, StandardOpenOption.APPEND)) {
//                {
//                    fc.
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

        // Charset charset = StandardCharsets.US_ASCII;
//            String s = "test";
//            try (var writer = newBufferedWriter(path)) {
//                boolean isFileRegularExecutable = isRegularFile(path) &
//                        isReadable(path) &
//                        isExecutable(path);
//
//                if (isFileRegularExecutable) {
//                    System.out.println("isFileRegularExecutable = " + true);
//                    writer.write(s, 0, s.length());
//                }
//
//            } catch (SecurityException x) {
//                System.err.format("%s not a  regular, readable, executable file", x);
//            } catch (NoSuchFileException x) {
//                System.err.format("%s does not exist\n", x.getFile());
//            } catch (IOException x) {
//                System.err.format("IOException: %s%n", x);
//            }

//            try {
//                var target = Path.of("C:\\Users\\Public\\Documents\\into_art\\created\\test.json");
//                move(path,
//                        target,
//                        REPLACE_EXISTING,
//                        ATOMIC_MOVE);
//            } catch (NoSuchFileException x) {
//                System.err.format("%s: no such file or directory%n", path);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

    }


}

package com.demo.streamsandfiles;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CreateFileSystems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] data = { "Line 1", "line 2 2", "Line 3 3 3", "Line 4 4 4 4", "Line 5 5 5 5 5" };
		try (FileSystem zipFs = openZip(
				Paths.get("C://Users//DURGA PRASAD//Documents//pro languages//java//myData.zip"))) {
			CopyToZip(zipFs);
			writeToZip2(zipFs, data);
			writeToZip1(zipFs, data);
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName() + " " + e.getMessage());
		}
	}

	private static FileSystem openZip(Path zipPath) throws IOException, URISyntaxException {
		Map<String, String> ProvideProps = new HashMap<>();
		ProvideProps.put("create", "true");
		URI zipUri = new URI("jar:file", zipPath.toUri().getPath(), null);
		FileSystem zipFs = FileSystems.newFileSystem(zipUri, ProvideProps);
		return zipFs;
	}

	private static void CopyToZip(FileSystem zipFs) throws IOException {
		// TODO Auto-generated method stub
		Path sourceFile = Paths.get("C://Users//DURGA PRASAD//Documents//pro languages//java//file.txt");
		// Path SourceFile = FileSystems.getDefault()
		// .getPath("C://Users//DURGA PRASAD//Documents//pro
		// languages//java//myData.zip");
		Path destFile = zipFs.getPath("/filecopied.txt");
		Files.copy(sourceFile, destFile, StandardCopyOption.REPLACE_EXISTING);
	}

	private static void writeToZip1(FileSystem zipFs, String[] data) throws IOException {
		try (BufferedWriter br = Files.newBufferedWriter(zipFs.getPath("/newFile1.txt"))) {
			for (String s : data) {
				br.write(s);
				br.newLine();
			}
		}
	}

	private static void writeToZip2(FileSystem zipFs, String[] data) throws IOException {
		Files.write(zipFs.getPath("/newFile2.txt"), Arrays.asList(data), Charset.defaultCharset(),
				StandardOpenOption.CREATE);
	}

}

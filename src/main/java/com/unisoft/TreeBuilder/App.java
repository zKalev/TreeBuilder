package com.unisoft.TreeBuilder;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.logging.Logger;

public class App {
	private static final String charsetName = "UTF-8";
	private static final Logger log = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			log.warning("execution: java -jar <input> <output>");
			return;
		}
		String input = args[0];
		String outputFilePath = args[1];

		URL url = new URL(input);
		URLConnection site = url.openConnection();
		InputStream is = site.getInputStream();

		FileWriter fr = new FileWriter(new File(outputFilePath));
		Scanner scanner = new Scanner(new BufferedInputStream(is), charsetName);
		log.info("------------------------Start------------");
		log.info("Building tree ...");
		Tree t = new Tree();
		try {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] elem = line.split("[,]");
				int nodeNum = Integer.parseInt(elem[0]);
				int fatherNum = Integer.parseInt(elem[1]);
				int info = Integer.parseInt(elem[2]);
				t.addNode(nodeNum, fatherNum, info);

			}
		} finally {
			scanner.close();
		}
		log.info("------------------The tree is built-----------");
		log.info("-------------Start writing in output file------------");
		try {
			for (TreeNode n : t.getSetOfNodeThatHaveChildrenButGraidChildren()) {
				StringBuilder sb = new StringBuilder();
				System.out.println(n.getNodeNum() + "," + n.getHeight());
				sb.append(n.getNodeNum());
				sb.append(",");
				sb.append(n.getHeight());
				fr.write(sb.toString());
				fr.write("\n");
			}
		} finally {
			fr.close();
		}
	}
}

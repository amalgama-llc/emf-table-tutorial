package com.amalgamasimulation.tabletutorial.application.editors;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * Code of the examples, read from the source file of a tab.
 * A snippet is the code between the {@code // copy:<id>} and {@code // copy:end} lines.
 */
class CodeSnippets {

	private static final String BEGIN = "// copy:";
	private static final String END = "// copy:end";

	private final Class<?> tabClass;
	private Map<String, String> snippets;

	CodeSnippets(Class<?> tabClass) {
		this.tabClass = tabClass;
	}

	/**
	 * Puts the snippet into the clipboard and returns it. If the source file is not found, shows a message
	 * and returns {@code null}.
	 */
	String copy(String id, Shell shell) {
		String code = get(id);
		if (code == null) {
			MessageBox box = new MessageBox(shell, SWT.ICON_WARNING | SWT.OK);
			box.setText("Source not found");
			box.setMessage("The code of this example is read from " + sourcePath() + ", and the file is not found.");
			box.open();
			return null;
		}
		toClipboard(code, shell);
		return code;
	}

	void toClipboard(String code, Shell shell) {
		Clipboard clipboard = new Clipboard(shell.getDisplay());
		try {
			clipboard.setContents(new Object[] { code }, new Transfer[] { TextTransfer.getInstance() });
		} finally {
			clipboard.dispose();
		}
	}

	/** Returns the snippet, or {@code null} if the source file or the snippet is not found. */
	String get(String id) {
		return snippets().get(id);
	}

	/** Returns all snippets of the tab by id. */
	Map<String, String> snippets() {
		if (snippets == null) {
			String source = readSource();
			snippets = source == null ? Map.of() : parse(source);
		}
		return snippets;
	}

	private String sourcePath() {
		return "src/" + tabClass.getName().replace('.', '/') + ".java";
	}

	private String readSource() {
		Bundle bundle = FrameworkUtil.getBundle(tabClass);
		URL url = bundle == null ? null : bundle.getEntry(sourcePath());
		if (url == null) {
			return null;
		}
		try (InputStream in = url.openStream()) {
			return new String(in.readAllBytes(), StandardCharsets.UTF_8);
		} catch (IOException e) {
			return null;
		}
	}

	private static Map<String, String> parse(String source) {
		Map<String, String> result = new LinkedHashMap<>();
		String id = null;
		List<String> lines = new ArrayList<>();
		for (String line : source.split("\r?\n")) {
			String trimmed = line.trim();
			if (id == null) {
				if (trimmed.startsWith(BEGIN) && !trimmed.equals(END)) {
					id = trimmed.substring(BEGIN.length()).trim();
					lines.clear();
				}
			} else if (trimmed.equals(END)) {
				result.put(id, unindent(lines));
				id = null;
			} else {
				lines.add(line);
			}
		}
		return result;
	}

	private static String unindent(List<String> lines) {
		int indent = Integer.MAX_VALUE;
		for (String line : lines) {
			if (!line.isBlank()) {
				int i = 0;
				while (i < line.length() && Character.isWhitespace(line.charAt(i))) {
					i++;
				}
				indent = Math.min(indent, i);
			}
		}
		StringBuilder code = new StringBuilder();
		for (String line : lines) {
			code.append(line.isBlank() ? "" : line.substring(indent)).append(System.lineSeparator());
		}
		return code.toString().stripTrailing();
	}
}

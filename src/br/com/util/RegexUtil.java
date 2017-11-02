package br.com.util;

import java.rmi.ServerException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
	private static final Pattern regexAll = Pattern.compile("/carros");
	private static final Pattern regexById = Pattern.compile("/carros/([0-9]*)");

	// verifica se a url e no padrao "/carros/id

	public static Long matchId(String requestUri) throws ServerException {
		// Verifica o id
		Matcher matcher = regexById.matcher(requestUri);
		if (matcher.find() && matcher.groupCount() > 0) {
			String s = matcher.group(1);
			if (s != null && s.trim().length() > 0) {
				Long id = Long.parseLong(s);
				return id;
			}
		}
		return null;
	}

	// verifica se a url e no padrao "carro/id

	public boolean matchAll(String reString) throws ServerException {
		Matcher matcher = regexAll.matcher(reString);
		if (matcher.find()) {
			return true;
		}
		return false;
	}

}

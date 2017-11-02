package br.com.rest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.jettison.JettisonFeature;

public class MyApplication extends Application{

	@Override
	public Set<Object> getSingletons() {
		// Driver do Jetson para gerar Json
		Set<Object> singletons = new HashSet<>();
		singletons.add(new JettisonFeature());
		return singletons;
	}

	@Override
	public Map<String, Object> getProperties() {
		Map<String, Object> properties = new HashMap<>();
		// Configura o package para fazer scan das classes @REST
		properties.put("jersey.config.server.provider.packages", "br.com.rest");
		return properties;
	}
	

}

package br.com.carros.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.domain.Carro;
import br.com.domain.ListaCarro;
import br.com.domain.Response;
import br.com.service.CarroService;
import br.com.util.JAXBUtil;
import br.com.util.RegexUtil;
import br.com.util.ServletUtil;

@WebServlet("/carros/*")
public class CarrosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CarroService service = new CarroService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Pega o id
		String requestUri = req.getRequestURI();
		// verifica o id
		Long id = RegexUtil.matchId(requestUri);

		if (id != null) {
			Carro carro = service.getCarro(id);

			if (carro != null) {
				// se encontrado retorna o carro
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String json = gson.toJson(carro);
				ServletUtil.writeJson(resp, json);
			} else {
				// senao encaminha 404
				resp.sendError(404, "Carro não encontrado idiota");
			}
		} else {
			// Se nao retorna a lista de carros
			List<Carro> carros = service.getCarros();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(carros);
			ServletUtil.writeJson(resp, json);
		}

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		Carro carro = getCarroFromRequest(request);
		service.save(carro);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(carro);
		ServletUtil.writeJson(resp, json);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestUri = req.getRequestURI();
		Long id = RegexUtil.matchId(requestUri);
		if(id!=null) {
			service.delete(id);
			Response r = Response.Ok("Carro excluído com sucesso");
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(r);
			ServletUtil.writeJson(resp, json);
		}else {
			resp.sendError(404,"UrL inválida!");
		}
	}

	private Carro getCarroFromRequest(HttpServletRequest req) {
		Carro c = new Carro();
		String id = req.getParameter("id");
		if (id != null) {
			// Buscar OBJ no banco
			c = service.getCarro(Long.parseLong(id));
		}
		c.setNome(req.getParameter("nome"));
		c.setDesc(req.getParameter("descricao"));
		c.setUrlFoto(req.getParameter("url_foto"));
		c.setUrlVideo(req.getParameter("url_video"));
		c.setLatitude(req.getParameter("latitude"));
		c.setLongitude(req.getParameter("longitude"));
		c.setTipo(req.getParameter("tipo"));

		return c;
	}

}


package services;

import model.Article;
import model.Message;
import providers.ArticleProvider;
import providers.ArticleProvider;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("article")
public class ArticleServices {

    @POST
    @Path("create")
    @Consumes("application/json")
    @Produces("application/json")
    public Response create(Article article){
        try{
            ArticleProvider provider = new ArticleProvider();
            provider.createArticle(article);
            return Response
                    .status(200)
                    .entity(new Message("info","Completado"))
                    .build();
        }catch(Exception e){
            return Response
                    .status(500)
                    .entity(new Message("Excepcion",e.getMessage()))
                    .build();
        }
    }
}
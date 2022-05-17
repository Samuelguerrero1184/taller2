
package services;

import model.Article;
import model.Message;
import providers.ArticleProvider;
import providers.ArticleProvider;

import javax.ws.rs.*;
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

    @DELETE
    @Path("{order}/{product}/{amount}")
    @Produces("application/json")
    public Response deleteProduct(@PathParam("order") int order, @PathParam("product") int product, @PathParam("amount") int amount){
        try{
            ArticleProvider provider = new ArticleProvider();
            provider.deleteArticle(order,product,amount);
            return Response
                    .status(200)
                    .entity(new Message("info","Completado"))
                    .build();
        }catch(Exception e){
            return Response
                    .status(500)
                    .entity(new Message("Exception",e.getMessage()))
                    .build();
        }
    }
}
package controllers;

import com.avaje.ebean.Model;
import models.Product;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.products.index;
import views.html.products.create;

import java.util.List;

import static play.data.Form.form;

/**
 * Created by Vamshi on 9/11/2016.
 */
public class ProductController extends Controller {

    public Result createProduct(){
        return ok(create.render(form(Product.class)));
    }

    public Result listProducts(){
        List<Product> products = new Model.Finder(Product.class).all();
//        return ok(toJson(products));
        return ok(index.render(products));
    }

    public Result saveProduct(){
        Form<Product> form = form(Product.class).bindFromRequest();
        if(form.hasErrors()) {
            return badRequest(form.toString());
        } else {
            Product data = form.get();
            data.save();
            return ok("Product created successfully.<br>" + data.toString());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import data.Dish;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Alex
 */
public class TableItemDish extends SimpleTagSupport {

    private Dish dish;
    private boolean name;
    private boolean dishId;
    private boolean description;
    private boolean contents;
    private boolean price;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     *
     * @throws javax.servlet.jsp.JspException
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            if (dishId) {
                out.print("<th>");
                out.print(dish.getDishId());
                out.print("</th>");
            }
            if (name) {
                out.print("<th>");
                out.print(dish.getName());
                out.print("</th>");
            }
            if (description) {
                out.print("<th>");
                out.print(dish.getDescription());
                out.print("</th>");
            }
            if (contents) {
                out.print("<th>");
                out.print(dish.getContent().toString());
                out.print("</th>");
            }
            if (price) {
                out.print("<th>");
                out.print(dish.getPrice());
                out.print("</th>");
            }

        } catch (java.io.IOException ex) {
            throw new JspException("Error in TableItem1 tag", ex);
        }
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public void setName(boolean name) {
        this.name = name;
    }

    public void setDishId(boolean dishId) {
        this.dishId = dishId;
    }

    public void setDescription(boolean description) {
        this.description = description;
    }

    public void setContents(boolean contents) {
        this.contents = contents;
    }

    public void setPrice(boolean price) {
        this.price = price;
    }

}

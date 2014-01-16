/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tag;

import data.Order;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Alex
 */
public class TableItemOrder extends SimpleTagSupport {
    private Order order;
    private boolean orderId;
    private boolean userId;
    private boolean orderContent;
    private boolean ready;
    private boolean summ;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     * @throws javax.servlet.jsp.JspException
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            if (orderId) {
                out.print("<th>");
                out.print(order.getOrderId());
                out.print("</th>");
            }
            if (userId) {
                out.print("<th>");
                out.print(order.getUserId());
                out.print("</th>");
            }
            if (orderContent) {
                out.print("<th>");
                out.print(order.getDishIDList().toString());
                out.print("</th>");
            }
            if (ready) {
                out.print("<th>");
                out.print(order.getReady());
                out.print("</th>");
            }
            if (summ) {
                out.print("<th>");
                out.print(order.getSumm());
                out.print("</th>");
            }
            
        } catch (java.io.IOException ex) {
            throw new JspException("Error in TableItemOrder tag", ex);
        }
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setOrderId(boolean orderId) {
        this.orderId = orderId;
    }

    public void setUserId(boolean userId) {
        this.userId = userId;
    }

    public void setOrderContent(boolean orderContent) {
        this.orderContent = orderContent;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public void setSumm(boolean summ) {
        this.summ = summ;
    }
    
}

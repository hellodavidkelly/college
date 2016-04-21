/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSF;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import session.CustomerFacade;

/**
 *
 * @author geraldine gray
 */
@ManagedBean
@RequestScoped
public class custController {

       private DataModel items = null;
    private String stateFilter="all";
    @EJB
    private session.CustomerFacade ejbFacade;
 /**
     * Creates a new instance of custController
     */
    public custController() {
    }

    public DataModel getItems() {
        if (getStateFilter().equals("all")) {
            items = new ListDataModel(getEjbFacade().findAll()); 
        } else {
            items = new ListDataModel(getEjbFacade().findByState(getStateFilter()));
        }
return items;
 }

public String updateItems() {
         items = getItems();	//update the data model
         return "index";		//return acstring indicating what page to display
     } 

    public void setItems(DataModel items) {
        this.items = items;
    }

    public String getStateFilter() {
        return stateFilter;
    }

    public void setStateFilter(String stateFilter) {
        this.stateFilter = stateFilter;
    }

    public CustomerFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(CustomerFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }
    
}

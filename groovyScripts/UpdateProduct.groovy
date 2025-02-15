import org.apache.ofbiz.entity.GenericEntityException;


def UpdatePRoductDetail() {

    try{
        
        productdata=delegator.findOne("Product",["productId":context.productId],false)
        if(productdata)
        {
            productdata.setNonPKFields(context)
            delegator.store(productdata)
        }
    }
    catch(GenericEntityException e)
    {
        return error("Something went wrong")
    }
    
    return  "dsdnknd"
  
}


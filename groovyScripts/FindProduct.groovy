import org.apache.ofbiz.entity.Delegator
import org.apache.ofbiz.entity.DelegatorFactory
import org.apache.ofbiz.entity.GenericEntityException
import org.apache.ofbiz.entity.util.EntityQuery
import org.apache.ofbiz.base.util.Debug

def FindproductDetail() {
   
    def result = [:]

   
    if (context == null) {
        context = [:]
    }

    Delegator delegator = (Delegator) context.get("delegator")
    if (!delegator) {
        delegator = DelegatorFactory.getDelegator("default")
    } 

    String productName = context.get("productName")
    String productprice = context.get("productprice")
    String productCategory = context.get("productCategory")
    String productFeature = context.get("productFeature")
    
    List productlist = []
    
    try {
        def query = EntityQuery.use(delegator).from("ProductAndCategoryViewEntity")
    
        if (productName) {
            query = query.where("productName", productName)
        }
        if(productCategory)
        {
            query=query.where("productCategoryId",productCategory)
        }
        if(productFeature)
        {
            query=query.where("productFeatureId",productFeature)
        }
        if(productprice)
        {
            query=query.where("price",productprice)
        }
    
        productlist = query.queryList()
    } catch (GenericEntityException e) {
        Debug.logError("Error in FindproductDetail service: " + e, "ProductService")
    }
    
    result.productlist = productlist
    return result
}

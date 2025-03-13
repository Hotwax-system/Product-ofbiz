import org.apache.ofbiz.entity.Delegator
import org.apache.ofbiz.entity.DelegatorFactory
import org.apache.ofbiz.entity.GenericEntityException
import org.apache.ofbiz.entity.util.EntityQuery
import org.apache.ofbiz.base.util.Debug

def FindproductDetail() {
    Debug.logInfo("Fetching product list...", "ProductService")

    if (context == null) {
        context = [:]
    }

    Delegator delegator = (Delegator) context.get("delegator") ?: DelegatorFactory.getDelegator("default")

    String productName = context.get("productName")
    String productPricestring = context.get("productPrice")
    String productFeature = context.get("productFeature")
    def productPrice = productPricestring ? new BigDecimal(productPricestring) : BigDecimal.ZERO
    
    List productlist = []
    
    try {
        def query = EntityQuery.use(delegator).from("ProductAndCategoryViewEntity")

        if (productName) {
            query = query.where("productName", productName)
        }
        if(productId)
        {
             query = query.where("productId", productId)
        }
        if (productFeature) {
            query = query.where("productFeatureDescription", productFeature)
        }
        if (productPrice) {
            query = query.where("productPrice", productPrice)
        }

        List productEntities = query.queryList()
        
        
        productlist = productEntities.collect { product ->
            [
                productId         : product.getString("productId"), 
                productName       : product.getString("productName"), 
                productDescription: product.getString("description") 
            ]
        }
        
    } catch (GenericEntityException e) {
        Debug.logError("Error in FindproductDetail service: " + e, "ProductService")
    }

    Debug.logInfo("Product List Before Setting in Context: " + productlist, "ProductService")

    context.productlist = productlist ?: []  
    
    Debug.logInfo("Product List After Setting in Context: " + context.productlist, "ProductService")
    
    return context 
}


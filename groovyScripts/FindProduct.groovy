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

    Delegator delegator = (Delegator) context.get("delegator")

    String productName = context.get("productName")
    String productPrice = context.get("productPrice")
    String productCategory = context.get("productCategory")
    String productFeature = context.get("productFeature")
    
    List productlist = []
    
    try {
        def query = EntityQuery.use(delegator).from("ProductAndCategoryViewEntity")

        if (productName) {
            query = query.where("productName", productName)
        }
        if (productCategory) {
            query = query.where("productCategoryId", productCategory)
        }
        if (productFeature) {
            query = query.where("productFeatureId", productFeature)
        }
        if (productPrice) {
            query = query.where("price", productPrice)
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


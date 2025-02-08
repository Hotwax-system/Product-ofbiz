<form method="post" action="<@ofbizUrl>FindProduct</@ofbizUrl>" name="AddOfbizDemo" class="form-horizontal">

    <div class="control-group">
        <label class="control-label" for="ProductName">Product Name</label>
        <div class="controls">
            <input type="text" id="ProductName" name="ProductName" required>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="ProductCategory">Product Category</label>
        <div class="controls">
            <input type="text" id="ProductCategory" name="ProductCategory" required>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="ProductPrice">Product Price</label>
        <div class="controls">
            <input type="text" id="ProductPrice" name="ProductPrice" required>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="ProductFeature">Product Feature</label>
        <div class="controls">
            <input type="text" id="ProductFeature" name="ProductFeature" required>
        </div>
    </div>

    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn">${uiLabelMap.CommonAdd}</button>
        </div>
    </div>

</form>

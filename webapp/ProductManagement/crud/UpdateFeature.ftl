<form method="post" action="<@ofbizUrl>UpdateFeature</@ofbizUrl>" name="UpdateFeatureForm" class="form-horizontal">

    <div class="control-group">
        <label class="control-label" for="productId">Product ID</label>
        <div class="controls">
            <input type="text" id="productId" name="productId" required>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="productFeatureoldId">Old Product Feature ID</label>
        <div class="controls">
            <input type="text" id="productFeatureoldId" name="productFeatureoldId">
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="productFeatureNewId">New Product Feature ID</label>
        <div class="controls">
            <input type="text" id="productFeatureNewId" name="productFeatureNewId">
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="productFeatureApplTypeId">Feature Application Type</label>
        <div class="controls">
            <input type="text" id="productFeatureApplTypeId" name="productFeatureApplTypeId">
        </div>
    </div>

    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn">Update Feature</button>
        </div>
    </div>

</form>

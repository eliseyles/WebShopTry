<#import "parts/common.ftl" as c>

<@c.page>
<form class="needs-validation" novalidate method="post">
    <div class="form-row">

        <div class="col">
            <label for="validationTooltip01">Product title</label>
            <input type="text" class="form-control" name="title" id="validationTooltip01" placeholder="Title" required>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
        </div>
    </div>
    <!--<div class="form-group">-->
        <!--<label class="mt-2" for="exampleFormControlSelect2">Category</label>-->
        <!--<select multiple class="form-control" id="exampleFormControlSelect2">-->
            <!--<option>1</option>-->
            <!--<option>2</option>-->
            <!--<option>3</option>-->
            <!--<option>4</option>-->
            <!--<option>5</option>-->
        <!--</select>-->
    <!--</div>-->

    <!--<div class="form-group">-->
        <!--<label class="mt-1" for="exampleFormControlTextarea1">Description</label>-->
        <!--<textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>-->
    <!--</div>-->

    <!--<div class="form-group">-->
        <!--<label class="mt-1" for="exampleFormControlTextarea1">Price</label>-->
        <!--<div class="input-group">-->
            <!--<div class="input-group-prepend">-->
                <!--<span class="input-group-text" id="inputGroupPrepend2">$</span>-->
            <!--</div>-->
            <!--<input type="text" class="form-control" id="price" value="20.00" required>-->
        <!--</div>-->
    <!--</div>-->

    <!--<div class="form-group">-->
        <!--<label class="mt-2" for="exampleFormControlSelect2">Location</label>-->
        <!--<select multiple class="form-control" id="location">-->
            <!--<option>1</option>-->
            <!--<option>2</option>-->
            <!--<option>3</option>-->
            <!--<option>4</option>-->
            <!--<option>5</option>-->
        <!--</select>-->
    <!--</div>-->

    <!--<div class="form-group">-->
        <!--<label for="validationTooltip01">Seller name</label>-->
        <!--<input type="text" class="form-control" id="name" value="Name" required>-->
        <!--<div class="valid-tooltip">-->
            <!--Looks good!-->
        <!--</div>-->
    <!--</div>-->

    <!--<div class="form-group">-->
        <!--<label class="mt-1" for="exampleFormControlTextarea1">Price</label>-->
        <!--<div class="input-group">-->
            <!--<div class="input-group-prepend">-->
                <!--<span class="input-group-text" id="number">+375</span>-->
            <!--</div>-->
            <!--<input type="text" class="form-control" id="phoneNumber" value="25..." required>-->
        <!--</div>-->
    <!--</div>-->


    <button class="btn btn-primary" type="submit" >Add product</button>
</form>
</@c.page>
<#import "parts/common.ftl" as c>

<@c.page>

<#if message??>
<div class="alert alert-danger" role="alert">
    ${message}
</div>
</#if>

<#if exception??>
<div class="alert alert-danger" role="alert">
    ${exception?ifExists}
</div>
</#if>


<form class="needs-validation" novalidate method="post">

    <div >
        <div class="col mb-3">
            <label for="validationTooltip01">Product title</label>
            <input type="text" class="form-control" name="title" id="validationTooltip01"
                   placeholder="Title" required>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
        </div>
        <div class="col mb-3">
            <label for="validationTooltip01">Product description</label>
            <input type="text" class="form-control" name="description" id="validationTooltip02"
                   placeholder="Description" required>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
        </div>
        <div class="col mb-3">
            <label for="validationTooltip01">Price</label>
            <input type="text" class="form-control" name="price" id="validationTooltip03"
                   placeholder="0.00" required>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
        </div>
    </div>

    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="btn btn-primary" type="submit" >Add product</button>
</form>
</@c.page>
<#import "parts/common.ftl" as c>

<@c.page>
<#if message??>
<div class="alert alert-danger" role="alert">
    ${message?ifExists}
</div>
</#if>

<#if exception??>
<div class="alert alert-danger" role="alert">
    ${exception?ifExists}
</div>
</#if>

<form action="/product" method="post">
    <div class="input-group mb-3">
        <div class="col-md-4">
            <input type="text" class="form-control" name="title" value="${(product.title)!}" placeholder="Title" aria-label="Title" aria-describedby="button-addon2">
        </div>
    </div>
    <div class="input-group mb-3">
        <div class="col-md-4">
            <input type="text" class="form-control" name="description" value="${(product.description)!}" placeholder="Description" aria-label="Description" aria-describedby="button-addon2">
        </div>
    </div>
    <div class="input-group mb-3">
        <div class="col-md-4">
            <input type="text" class="form-control" name="price" value="${(product.price)!}" placeholder="Price" aria-label="Price" aria-describedby="button-addon2">
        </div>
            <div>
                <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Save</button>
            </div>

    </div>
    <!--<input type="text" name="title" value="${product.title}">-->


    <input type="hidden" value="${product.id}" name="productId">
<input type="hidden" value="${_csrf.token}" name="_csrf">
    <!--<button type="submit" class="btn btn-primary">Save</button>-->
</form>

<form method="get" action="/product/delete" class="form-inline">
    <button type="submit" class="btn btn-primary">Delete</button>
    <input type="hidden" value="${product.id}" name="productId">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <!--<a href="/product/delete}" class="btn btn-primary">Delete</a>-->
</form>
</@c.page>
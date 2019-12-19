<#import "parts/common.ftl" as c>

<@c.page>
<form action="/product" method="post">
    <div class="input-group mb-3">
        <div class="col-md-4">
            <input type="text" class="form-control" name="title" value="${product.title}" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="button-addon2">
        </div>
            <div class="input-group-append">
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
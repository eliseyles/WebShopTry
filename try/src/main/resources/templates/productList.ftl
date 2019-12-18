<#import "parts/common.ftl" as c>

<@c.page>
<div class="card-columns">
    <#list products as pr>
    <div class="card my-3">
        <div class="m-2">
            <span>${pr.title}</span>
        </div>
        <div class="card-footer text-muted">
            <strong>${pr.ownerName}</strong>
        </div>
    </div>
    <#else>
    No products
</#list>
</div>
<!--<div class="row row-cols-1 row-cols-md-3">-->
    <!--<div class="col mb-4">-->
        <!--<#list (products)! as pr>-->
        <!--<div class="card my-3">-->
            <!--<div class="m-2">-->
                <!--<span>${pr.title}</span>-->
            <!--</div>-->
            <!--<div class="card-footer text-muted">-->
                <!--<strong>${pr.ownerName}</strong>-->
            <!--</div>-->
            <!--&lt;!&ndash;<div> <a href = "/product/${product.id}">edit</a> </div>&ndash;&gt;-->
        <!--</div>-->
    <!--</div>-->
    <!--<#else>-->
    <!--No products-->
<!--</#list>-->
<!--</div>-->
</@c.page>
<#macro login path isRegisterForm>

<form action="${path}" method="post">

    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> User Name:  </label>
        <div class="col-sm-6">
            <input type="text" name="username" class="form-control" placeholder="User name" />
            <#if isRegisterForm>
            <small id="passwordHelpBlock1" class="form-text text-muted">
                Login must be 3-20 characters, contains only letters, numbers and under score
            </small>
        </#if>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Password: </label>
        <div class="col-sm-6">
            <input type="password" name="password" class="form-control" placeholder="Password"/>
            <#if isRegisterForm>
            <small id="passwordHelpBlock" class="form-text text-muted">
                Your password must be 8-30 characters long.
            </small>
        </#if>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <#if !isRegisterForm><a class="mr-5" href="/registration">Add new user</a></#if>
<button class="btn btn-primary" type="submit"><#if isRegisterForm>Create<#else>Sign In</#if></button>
</form>
</#macro>

<#macro logout isLogin>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="btn btn-primary" type="submit" ><#if isLogin>Sign Out<#else>Sign In</#if></button>
</form>
</#macro>
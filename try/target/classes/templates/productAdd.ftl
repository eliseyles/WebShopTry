<#import "parts/common.ftl" as c>

<@c.page>
<form class="needs-validation" novalidate>
    <div class="form-row">
        <div class="col-md-4 mb-3">
            <label for="validationTooltip01">First name</label>
            <input type="text" class="form-control" id="validationTooltip01" value="Mark" required>
            <div class="valid-tooltip">
                Looks good!
            </div>
        </div>
        <div class="col-md-4 mb-3">
            <label for="validationTooltip02">Last name</label>
            <input type="text" class="form-control" id="validationTooltip02" value="Otto" required>
            <div class="valid-tooltip">
                Looks good!
            </div>
        </div>
        <div class="col-md-4 mb-3">
            <label for="validationTooltipUsername">Username</label>
            <div class="input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="validationTooltipUsernamePrepend">@</span>
                </div>
                <input type="text" class="form-control" id="validationTooltipUsername" aria-describedby="validationTooltipUsernamePrepend" required>
                <div class="invalid-tooltip">
                    Please choose a unique and valid username.
                </div>
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="col-md-6 mb-3">
            <label for="validationTooltip03">City</label>
            <input type="text" class="form-control" id="validationTooltip03" required>
            <div class="invalid-tooltip">
                Please provide a valid city.
            </div>
        </div>
        <div class="col-md-3 mb-3">
            <label for="validationTooltip04">State</label>
            <select class="custom-select" id="validationTooltip04" required>
                <option selected disabled value="">Choose...</option>
                <option>...</option>
            </select>
            <div class="invalid-tooltip">
                Please select a valid state.
            </div>
        </div>
        <div class="col-md-3 mb-3">
            <label for="validationTooltip05">Zip</label>
            <input type="text" class="form-control" id="validationTooltip05" required>
            <div class="invalid-tooltip">
                Please provide a valid zip.
            </div>
        </div>
    </div>
    <button class="btn btn-primary" type="submit">Submit form</button>
</form>
</@c.page>
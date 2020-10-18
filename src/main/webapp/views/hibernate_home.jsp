<%--
* This index.jsp created for MoraServletJSPLearn020 Project
*
* @Author: SLMORA
* @DateTime: 10/17/2020 4:12 PM
* <p>
* Version       Date            Editor              Note
* =====================================================================================================================
* 1.0           10/17/2020       	SLMORA              Initial Code (get copy from MoraServletJSPLearn020 index.jsp)
*
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${context}/resources/bootstrap/4.5.2/css/bootstrap.css">
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <link rel="stylesheet" href="${context}/resources/css/offcanvas.css">

    <title>Mora Hibernate Learn</title>
</head>
<body>
<main role="main" class="container">
    <div class="d-flex align-items-center p-3 my-3 text-white-50 bg-purple rounded shadow-sm">
        <img class="mr-3" src="${context}/resources/image/ClipartKey.png" alt="" width="38" height="60">
        <div class="lh-100">
            <h6 class="mb-0 text-white lh-100">Mora Hibernate Learn 003</h6>
            <small>Since 2020</small>
        </div>
    </div>

    <div class="my-3 p-3 bg-white rounded shadow-sm">
        <h6 class="border-bottom border-gray pb-2 mb-0">Recent updates</h6>
        <div class="media text-muted pt-3">
            <svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 32x32"><title>/hibernatelearnservlet02</title><rect width="100%" height="100%" fill="#6f42c1"/><text x="50%" y="50%" fill="#6f42c1" dy=".3em">32x32</text></svg>
            <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                <strong class="d-block text-gray-dark">/hibernatelearnservlet02</strong>
                Check Hibernate Item 01 Add Initial.
            </p>
        </div>
        <h3 class="mb-3">New Item Information</h3>
        <div class="media text-muted pt-3">
            <form class="needs-validation" action="${context}/hibernatelearnservlet02" method="POST" novalidate>
                <div class="mb-3">
                    <label for="itemName">Item Name</label>
                    <input type="text" class="form-control" id="itemName" name="itemName" placeholder="Fresh Milk" required>
                    <div class="invalid-feedback">
                        Please enter Item Name.
                    </div>
                </div>
                <div class="mb-3">
                    <label for="itemDescription">Item Description<span class="text-muted">(Optional)</span></label>
                    <input type="text" class="form-control" id="itemDescription" name="itemDescription" placeholder="Anchor Fresh Milk">
                    <div class="invalid-feedback">
                        Please enter Item Decription.
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-5 mb-3">
                        <label for="itemCategory">Item Category</label>
                        <select class="custom-select d-block w-100" id="itemCategory" name="itemCategory" required>
                            <option value="">Choose...</option>
                            <option value="b084827f-51b5-4a6e-806a-644cc7365551">Rice</option>
                            <option value="e2dcf2f7-f6a8-48ec-a314-bb941aa1bcb1">Milk</option>
                            <option value="26ff3334-6270-4351-b2ab-07f15155b256">Vegetable</option>
                            <option value="fba4eddc-2ade-4cc1-9943-da3edda5878d">Fruits</option>
                            <option value="ea93dfa9-a400-4f6f-b07f-2f5137379c76">Drinks</option>
                            <option value="204c0c14-3f9c-4399-9a2c-8baf50a06c79">Cake</option>
                            <option value="acea3c90-2d15-42fd-9987-e953dc1d8b6c">Oil</option>
                        </select>
                        <div class="invalid-feedback">
                            Please select a valid country.
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="measureUnit">Measure Unit</label>
                        <select class="custom-select d-block w-100" id="measureUnit" name="measureUnit" required>
                            <option value="">Choose...</option>
                            <option value="kilogram">kilogram</option>
                            <option value="Litter">Litter</option>
                            <option value="Unit">Unit</option>
                            <option value="Bottle">Bottle</option>
                            <option value="Gram">Gram</option>
                        </select>
                        <div class="invalid-feedback">
                            Please provide the Measure Unit.
                        </div>
                    </div>
                    <div class="col-md-3 mb-3">
                        <label for="unitPrice">Unit Price</label>
                        <input type="number" min="0.01" step="0.01" max="2500" class="form-control" id="unitPrice" name="unitPrice" placeholder="100.50" required>
                        <div class="invalid-feedback">
                            Unit Price required.
                        </div>
                    </div>
                </div>
                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block" type="submit">Submit Info</button>
            </form>
        </div>
        <div class="media text-muted pt-3">
            <svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 32x32"><title>/hibernatelearnservlet01</title><rect width="100%" height="100%" fill="#6f42c1"/><text x="50%" y="50%" fill="#6f42c1" dy=".3em">32x32</text></svg>
            <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                <strong class="d-block text-gray-dark">/hibernatelearnservlet01</strong>
                Check JDBC.
            </p>
        </div>
        <h3 class="mb-3">User Information</h3>
        <div class="media text-muted pt-3">
            <form class="needs-validation" action="${context}/hibernatelearnservlet01" method="POST" novalidate>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="firstName">First name</label>
                        <input type="text" class="form-control" id="firstName" name="firstName" placeholder="" value="" required>
                        <div class="invalid-feedback">
                            Valid first name is required.
                        </div>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="lastName">Last name</label>
                        <input type="text" class="form-control" id="lastName" name="lastName" placeholder="" value="" required>
                        <div class="invalid-feedback">
                            Valid last name is required.
                        </div>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="username">Username</label>
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text">@</span>
                        </div>
                        <input type="text" class="form-control" id="username" name="userName" placeholder="Username" required>
                        <div class="invalid-feedback" style="width: 100%;">
                            Your username is required.
                        </div>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="email">Email <span class="text-muted">(Optional)</span></label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="you@example.com">
                    <div class="invalid-feedback">
                        Please enter a valid email address for shipping updates.
                    </div>
                </div>
                <div class="mb-3">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" name="address" placeholder="1234 Main St" required>
                    <div class="invalid-feedback">
                        Please enter your shipping address.
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-5 mb-3">
                        <label for="country">Country</label>
                        <select class="custom-select d-block w-100" id="country" name="country" required>
                            <option value="">Choose...</option>
                            <option value="United States">United States</option>
                            <option value="Sri Lanka">Sri Lanka</option>
                        </select>
                        <div class="invalid-feedback">
                            Please select a valid country.
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="state">State</label>
                        <select class="custom-select d-block w-100" id="state" name="state" required>
                            <option value="">Choose...</option>
                            <option value="California">California</option>
                            <option value="Galle">Galle</option>
                            <option value="New York">New York</option>
                            <option value="Colombo">Colombo</option>
                            <option value="Kandy">Kandy</option>
                        </select>
                        <div class="invalid-feedback">
                            Please provide a valid state.
                        </div>
                    </div>
                    <div class="col-md-3 mb-3">
                        <label for="zip">Zip</label>
                        <input type="text" class="form-control" id="zip" name="zip" placeholder="" required>
                        <div class="invalid-feedback">
                            Zip code required.
                        </div>
                    </div>
                </div>
                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block" type="submit">Submit Info</button>
            </form>
        </div>
        <small class="d-block text-right mt-3">
            <a href="#">All updates</a>
        </small>
    </div>
</main>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${context}/resources/jquery/3.5.1/jquery-3.5.1.slim.min.js"></script>
<script src="${context}/resources/popper/1.16.1/umd/popper.min.js"></script>
<script src="${context}/resources/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="${context}/resources/js/offcanvas.js"></script>
</body>
</html>

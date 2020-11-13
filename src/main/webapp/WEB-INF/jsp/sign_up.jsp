<jsp:include page="views/_header.jsp"/>

<jsp:include page="views/_navbar.jsp"></jsp:include>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-5 ">
            <form action="${pageContext.request.contextPath}/signUp" method="post">
                <div class="form-group">
                    <label> Your first name</label>
                    <input name="name" class="form-control">
                </div>
                <div class="form-group">
                    <label>Age</label>
                    <input name="age" class="form-control" placeholder="Your age">
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input name="email" type="email" class="form-control" placeholder="Your email"
                           aria-describedby="emailHelp">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone
                        else.</small>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input name="password" type="password" class="form-control" placeholder="Your password">
                </div>
                <button type="submit" class="btn btn-primary" value="Send">Submit</button>
            </form>
        </div>
    </div>
</div>

<jsp:include page="views/_footer.jsp"/>
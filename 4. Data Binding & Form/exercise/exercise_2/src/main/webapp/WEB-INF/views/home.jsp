<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="submit" method="post" modelAttribute="medicaldeclaration">
    <table>
        <div>
            <div><label>Họ và tên</label></div>
            <div><form:input path="name"/></div>
        </div>

        <div>
            <div>
                <div><label>Năm sinh</label></div>
                <div>
                    <form:select path="yearOfBirth">
                        <form:options items="${years}"/>
                    </form:select>
                </div>
            </div>
            <div>
                <div><label>Giới</label></div>
                <div>
                    <form:select path="gender">
                        <form:options items="${genders}"/>
                    </form:select>
                </div>
            </div>
            <div>
                <div><label>Quốc gia</label></div>
                <div>
                    <form:select path="nationality">
                        <form:options items="${nationalitys}"/>
                    </form:select>
                </div>
            </div>
        </div>


        <div>
            <div><label>Số hộ chiếu hoặc CMND</label></div>
            <div>
                <form:input path="numberId"/>
            </div>
        </div>

        <div>
            <div>
                <form:checkboxes items="${vehicles}" path="vehicle"/>
            </div>
        </div>

        <div>
            <div><label>Số hiệu phương tiện</label></div>
            <div><form:input path="vehicleOfCode"/></div>
        </div>

        <div>
            <div><label>Số ghế</label></div>
            <div><form:input path="seatOfCode"/></div>
        </div>

        <div>
            <div><label>Ngày khởi hành</label></div>
            <div><form:input type="date" path="startDay"/></div>
        </div>

        <div>
            <div><label>Ngày kết thúc </label></div>
            <div><form:input type="date" path="endDay"/></div>
        </div>

        <div>
            <div><label>Trong vòng 14 ngày qua có đi đâu không?</label></div>
            <div><form:textarea path="info14Day"/></div>
        </div>

        <div>
            <div><input style="background:#0f86ff" type="submit" value="Update"></div>
            <div><input type="reset" value="Cancel"></div>
        </div>
    </table>
</form:form>
</body>
</html>

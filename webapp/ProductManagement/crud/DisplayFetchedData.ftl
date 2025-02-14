<#-- Debugging: Pura context print karne ke liye -->
<#-- <pre>${.data_model}</pre> -->

<html>
<head>
    <title>Product List</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>

    <h2>📦 Product List</h2>

    <#if productlist?? && productlist?size gt 0>
        <table>
            <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Description</th>
            </tr>
            <#list productlist as product>
                <tr>
                    <td>${product.productId!''}</td>
                    <td>${product.productName!''}</td>
                    <td>${product.productDescription!''}</td>
                </tr>
            </#list>
        </table>
    <#else>
        <p>No products found.</p>
    </#if>

    <h2>⚙️ Server Information</h2>
    <p><b>Server ID:</b> ${parameters.serverId!''}</p>
    <p><b>Root URL:</b> ${parameters.serverRootUrl!''}</p>
    <p><b>Component Name:</b> ${parameters.componentName!''}</p>
    <p><b>Current View:</b> ${parameters.currentView!''}</p>
    <p><b>Control Path:</b> ${parameters.controlPath!''}</p>
    <p><b>Time Zone:</b> ${parameters.timeZone!''}</p>
    <p><b>Locale:</b> ${parameters.locale!''}</p>
    <p><b>Visual Theme:</b> ${parameters.visualTheme!''}</p>

</body>
</html>

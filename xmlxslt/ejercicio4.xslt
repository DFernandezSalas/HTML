<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <title>Historial de Pedidos</title>
            </head>
            <body>
                <h1>Historial de Pedidos</h1>
                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th>Cliente</th>
                        <th>Producto</th>
                        <th>Cantidad</th>
                        <th>Total</th>
                    </tr>
                    <xsl:for-each select="pedidos/pedido">
                        <tr>
                            <td><xsl:value-of select="id"/></td>
                            <td><xsl:value-of select="cliente"/></td>
                            <td><xsl:value-of select="producto"/></td>
                            <td><xsl:value-of select="cantidad"/></td>
                            <td>$<xsl:value-of select="total"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>

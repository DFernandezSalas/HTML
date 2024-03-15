<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <title>Lista de Empleados</title>
            </head>
            <body>
                <h1>Lista de Empleados</h1>
                <table border="1">
                    <tr>
                        <th>Nombre</th>
                        <th>Puesto</th>
                        <th>Departamento</th>
                        <th>Salario</th>
                    </tr>
                    <xsl:for-each select="empleados/empleado">
                        <tr>
                            <td><xsl:value-of select="nombre"/></td>
                            <td><xsl:value-of select="puesto"/></td>
                            <td><xsl:value-of select="departamento"/></td>
                            <td>$<xsl:value-of select="salario"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>

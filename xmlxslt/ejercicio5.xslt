<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <title>Registro de Calificaciones</title>
            </head>
            <body>
                <h1>Registro de Calificaciones</h1>
                <table border="1">
                    <tr>
                        <th>Nombre</th>
                        <th>Edad</th>
                        <th>Materias</th>
                    </tr>
                    <xsl:for-each select="estudiantes/estudiante">
                        <tr>
                            <td><xsl:value-of select="nombre"/></td>
                            <td><xsl:value-of select="edad"/></td>
                            <td>
                                <ul>
                                    <xsl:for-each select="materias/materia">
                                        <li>
                                            <xsl:value-of select="nombre"/>: <xsl:value-of select="calificacion"/>
                                        </li>
                                    </xsl:for-each>
                                </ul>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>

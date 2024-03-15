<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <title>Lista de Libros</title>
            </head>
            <body>
                <h1>Lista de Libros</h1>
                <ul>
                    <xsl:for-each select="libros/libro">
                        <li>
                            <xsl:value-of select="titulo"/> por <xsl:value-of select="autor"/>
                        </li>
                    </xsl:for-each>
                </ul>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>


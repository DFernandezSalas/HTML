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
                    <xsl:for-each select="library/book">
                        <li>
                            <xsl:value-of select="title"/> por <xsl:value-of select="author"/> del genero <xsl:value-of select="genre"/> publicado el año <xsl:value-of select="year"/> por <xsl:value-of select="publisher"/>
                        </li>
                    </xsl:for-each>
                </ul>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>


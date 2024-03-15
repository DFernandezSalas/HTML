<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">
    <html>
      <body>
        <h2>Productos con precio superior a 30:</h2>
        <table border="1">
          <tr>
            <th>Nombre</th>
            <th>Precio</th>
          </tr>
          <xsl:apply-templates select="productos/producto"/>
        </table>
      </body>
    </html>
  </xsl:template>

  <xsl:template match="producto">
    <xsl:if test="precio > 30">
      <tr>
        <td><xsl:value-of select="nombre"/></td>
        <td><xsl:value-of select="precio"/></td>
      </tr>
    </xsl:if>
  </xsl:template>

</xsl:stylesheet>

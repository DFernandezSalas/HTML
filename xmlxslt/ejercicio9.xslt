<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">
    <html>
      <body>
        <h2>Colores de las frutas:</h2>
        <xsl:apply-templates select="frutas/fruta"/>
      </body>
    </html>
  </xsl:template>

  <xsl:template match="fruta">
    <p>
      <xsl:value-of select="@tipo"/>: 
      <xsl:choose>
        <xsl:when test="@tipo='manzana'">
          <xsl:text>Rojo</xsl:text>
        </xsl:when>
        <xsl:when test="@tipo='plátano'">
          <xsl:text>Amarillo</xsl:text>
        </xsl:when>
        <xsl:when test="@tipo='naranja'">
          <xsl:text>Naranja</xsl:text>
        </xsl:when>
        <xsl:otherwise>
          <xsl:text>Desconocido</xsl:text>
        </xsl:otherwise>
      </xsl:choose>
    </p>
  </xsl:template>

</xsl:stylesheet>

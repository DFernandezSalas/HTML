<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <head>
        <title>Información del Libro</title>
      </head>
      <body>
        <h1>Datos del Libro</h1>
        <p><strong>Título:</strong> <xsl:value-of select="/libro/titulo"/></p>
        <p><strong>Autor:</strong> <xsl:value-of select="/libro/autor"/></p>
        <p><strong>Año de Publicación:</strong> <xsl:value-of select="/libro/anno"/></p>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>

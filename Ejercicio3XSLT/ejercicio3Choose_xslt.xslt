<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
				<title>Lista de Libros</title>
			</head>
			<body>
				<h1>Lista de Libros</h1>
				<table border="1">
					<xsl:for-each select="library/book">
						<tr>
							<xsl:choose>
								<xsl:when test="year &lt; 1960">
									<td bgcolor="#33cc33">
										<xsl:value-of select="title" /> por <xsl:value-of
											select="author" /> del genero <xsl:value-of
											select="genre" /> publicado el año <xsl:value-of
											select="year" /> por <xsl:value-of
											select="publisher" />
									</td>
								</xsl:when>
								<xsl:when test="year &gt; 1960">
									<td bgcolor="#ff0000">
										<xsl:value-of select="title" /> por <xsl:value-of
											select="author" /> del genero <xsl:value-of
											select="genre" /> publicado el año <xsl:value-of
											select="year" /> por <xsl:value-of
											select="publisher" />
									</td>
								</xsl:when>
								<xsl:otherwise>
								</xsl:otherwise>
							</xsl:choose>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>


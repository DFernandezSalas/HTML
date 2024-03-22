<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<!-- Key definition to group materias by nombre -->
	<xsl:key name="materia-by-nombre" match="materia" use="nombre" />

	<!-- Template to match the root element -->
	<xsl:template match="/">
		<html>
			<head>
				<style>
					.suspensocolor { background-color: red; }
					.suficientecolor { background-color: orange; }
					.biencolor { background-color: blue; }
					.notablecolor { background-color: brown; }
					.sobresalientecolor { background-color: green; }
				</style>
			</head>
			<body>
				<table border="1">
					<tr>
						<th>Estudiante</th>
						<!-- Loop through unique materia nombres -->
						<xsl:for-each
							select="//materia[generate-id() = generate-id(key('materia-by-nombre', nombre)[1])]">
							<th>
								<xsl:value-of select="nombre" />
							</th>
						</xsl:for-each>
					</tr>
					<!-- Call estudiante template for each estudiante -->
					<xsl:apply-templates select="//estudiante" />
				</table>
			</body>
		</html>
	</xsl:template>

	<!-- Template to match each estudiante -->
	<xsl:template match="estudiante">
		<tr>
			<td>
				<xsl:value-of select="nombre" />
			</td>
			<!-- Loop through unique materia nombres -->
			<xsl:variable name="currentEstudiante" select="." />
			<xsl:for-each
				select="//materia[generate-id() = generate-id(key('materia-by-nombre', nombre)[1])]">
				<!-- Get the nota for the current materia and estudiante -->
				<xsl:variable name="materiaActual" select="nombre" />
				<xsl:variable name="nota"
					select="$currentEstudiante/calificaciones/materia[nombre = $materiaActual]/nota" />
				<!-- Apply class based on nota -->
				<xsl:choose>
					<xsl:when test="$nota &lt; 45">
						<td class="suspensocolor">
							<xsl:value-of select="$nota" />
						</td>
					</xsl:when>
					<xsl:when test="$nota &gt;= 45 and $nota &lt;= 55">
						<td class="suficientecolor">
							<xsl:value-of select="$nota" />
						</td>
					</xsl:when>
					<xsl:when test="$nota &gt; 55 and $nota &lt;= 65">
						<td class="biencolor">
							<xsl:value-of select="$nota" />
						</td>
					</xsl:when>
					<xsl:when test="$nota &gt; 65 and $nota &lt;= 75">
						<td class="notablecolor">
							<xsl:value-of select="$nota" />
						</td>
					</xsl:when>
					<xsl:when test="$nota &gt; 75 and $nota &lt;= 100">
						<td class="sobresalientecolor">
							<xsl:value-of select="$nota" />
						</td>
					</xsl:when>
					<xsl:otherwise>
						<td>
							<xsl:value-of select="$nota" />
						</td>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:for-each>
		</tr>
	</xsl:template>

</xsl:stylesheet>

<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:msxsl="urn:schemas-microsoft-com:xslt"
	xmlns:fx="#fx-functions" exclude-result-prefixes="msxsl fx">
	<xsl:output method="html" version="4.0" indent="yes"
		xmlns:xsl="http://www.w3.org/1999/XSL/Transform" />
	<xsl:template match="//dataroot" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
		<html>
			<head>
				<META HTTP-EQUIV="Content-Type" CONTENT="text/html;charset=UTF-8" />
				<title>book</title>
				<style type="text/css"></style>
			</head>
			<body link="#0c0000" vlink="#050000">
				<table border="1" bgcolor="#ffffff" cellspacing="0"
					cellpadding="0" id="CTRL1">
					<colgroup>
						<col style="TEXT-ALIGN: right; WIDTH: 2.38cm" />
						<col style="WIDTH: 5.449cm" />
						<col style="TEXT-ALIGN: right; WIDTH: 5.925cm" />
						<col style="WIDTH: 8.518cm" />
					</colgroup>
					<tbody>
						<tr>
							<td>
								<div align="center">
									<strong>ID</strong>
								</div>
							</td>
							<td>
								<div align="center">
									<strong>BRIEF</strong>
								</div>
							</td>
							<td>
								<div align="center">
									<strong>PUBLISH_YEAR</strong>
								</div>
							</td>
							<td>
								<div align="center">
									<strong>AUTHOR</strong>
								</div>
							</td>
						</tr>
					</tbody>
					<tbody id="CTRL2">
						<xsl:for-each select="book">
							<!-- Cache the current node incase the a field is formatted -->
							<xsl:value-of select="fx:CacheCurrentNode(.)" />
							<tr>
								<td>
									<xsl:value-of select="ID" />
								</td>
								<td>
									<xsl:value-of select="BRIEF" />
								</td>
								<td>
									<xsl:value-of select="PUBLISH_YEAR" />
								</td>
								<td>
									<xsl:value-of select="AUTHOR" />
								</td>
							</tr>
						</xsl:for-each>
					</tbody>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>

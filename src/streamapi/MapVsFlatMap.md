<b style="color: blue"> Difference between map() and flatMap() in java 8</b>
<table>
<tr>
<td>map()</td><td>flatMap()</td>
</tr>
<tr>
<td>It processes stream of values</td>
<td>It process stream of steam of values</td>
</tr>
<tr>
<td>It only does mapping</td>
<td>It does mapping and flattenning of data</td>
</tr>
<tr>
<td>It is a one to one mapping</td>
<td>It is a one to many mapping</td>
<tr>
<td>Data transformation : From Stream to Stream</td>
<td>Data transformation : From Stream &lt Stream &gt to Stream</td>
</tr>
<tr>
<td>Use this method when the mapper function is producing a single value for each input value</td>
<td>Use this method when the mapper function is producing multiple values for each input value</td>
</tr>
</table>
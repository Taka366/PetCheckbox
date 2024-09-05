  const table = document.getElementById("petTable");
  const rows = Array.from(table.rows).slice(1);
  const isNumeric = !isNaN(rows[0].cells[1].innerText);

  rows.sort((a, b) => {
    const cellA = a.cells[1].innerText;
    const cellB = b.cells[1].innerText;
    return isNumeric ? cellB - cellA : cellB.localeCompare(cellA);
  });

  rows.forEach(row => table.appendChild(row));
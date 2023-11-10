/* eslint-disable @typescript-eslint/no-explicit-any */
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { Container } from "@mui/material";

export declare interface BasicTableProps {
  rows: [];
}

export default function BasicTable({ rows }: BasicTableProps) {
  console.log(rows);

  return (
    <TableContainer component={Paper}>
      <Table aria-label="simple table">
        <TableHead>
          <TableRow>
            {rows[0]
              ? Object.getOwnPropertyNames(rows[0]).map((item: any) => {
                  return (
                    <TableCell align="right">{item.toUpperCase()}</TableCell>
                  );
                })
              : "Not found data"}
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map((row) => (
            <TableRow
              key={row.title}
              sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
            >
              <TableCell component="th" align="right" scope="row">
                {row.title}
              </TableCell>
              <TableCell align="right">{row.datetime}</TableCell>
              <TableCell align="right">{row.seats}</TableCell>
              <TableCell align="right">{row.address}</TableCell>
              <TableCell align="right">$ {row.subtotal}</TableCell>
            </TableRow>
          ))}
          <TableRow>
            <TableCell></TableCell>
            <TableCell></TableCell>
            <TableCell></TableCell>
            <TableCell></TableCell>
            <TableCell align="right">
              Total: ${" "}
              {rows.reduce((total, subtotal) => total + subtotal.subtotal, 0)}
            </TableCell>
          </TableRow>
        </TableBody>
      </Table>
    </TableContainer>
  );
}

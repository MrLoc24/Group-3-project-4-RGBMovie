import { Navigate, Outlet } from "react-router-dom";
import { useSelector } from "react-redux";

const PrivateRoute = () => {
  const { customerInfo } = useSelector((state: any) => state.auth);
  return customerInfo ? <Outlet /> : <Navigate to="/login" replace />;
};

export default PrivateRoute;

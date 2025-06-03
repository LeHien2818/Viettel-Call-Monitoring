import { Navigate, useRoutes } from "react-router-dom"
import { LoginPage } from "./pages/login"
import { DashboardPage } from "./pages/dashboard"
import { ProtectedRoute } from "./components/ProtectedRoute"
import type { FC } from "react"

const routes = [
  {
    path: "/",
    element: <LoginPage />,
  },
  {
    path: "/dashboard",
    element: (
      <ProtectedRoute>
        <DashboardPage />
      </ProtectedRoute>
    ),
  },
  {
    path: "*",
    element: <Navigate to="/" replace />,
  },
]

const AppRouter: FC = () => {
  return useRoutes(routes)
}

export default AppRouter
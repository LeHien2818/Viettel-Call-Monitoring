import { type ReactNode, useEffect, useState } from "react"
import { Navigate } from "react-router-dom"
import { Center, Loader } from "@mantine/core"

interface ProtectedRouteProps {
  children: ReactNode
}

export function ProtectedRoute({ children }: ProtectedRouteProps) {
  const [isLoading, setIsLoading] = useState(true)
  const [isAuthenticated, setIsAuthenticated] = useState(false)

  useEffect(() => {
    const checkAuth = () => {
      const isLoggedIn = localStorage.getItem("isLoggedIn") === "true"
      setIsAuthenticated(isLoggedIn)
      setIsLoading(false)
    }

    checkAuth()
  }, [])

  if (isLoading) {
    return (
      <Center h="100vh">
        <Loader size="lg" />
      </Center>
    )
  }

  if (!isAuthenticated) {
    return <Navigate to="/" replace />
  }

  return <>{children}</>
}

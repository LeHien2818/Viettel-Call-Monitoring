import './App.css'
import { MantineProvider } from "@mantine/core"
import { Notifications } from "@mantine/notifications"
import "@mantine/core/styles.css"
import "@mantine/notifications/styles.css"
import AppRouter from './Router'
import { QueryClient, QueryClientProvider } from '@tanstack/react-query'
import { ReactQueryDevtools } from '@tanstack/react-query-devtools'

function App() {

  const queryClient = new QueryClient({
  defaultOptions: {
    queries: {
      refetchOnWindowFocus: false,
      retry: 1,
    },
  },
})

  return (
    <>
      <MantineProvider
      theme={{
        primaryColor: "blue",
        fontFamily: "Inter, sans-serif",
      }}
    >
      <Notifications position="top-right" />
      <QueryClientProvider client={queryClient}>
        
        <ReactQueryDevtools initialIsOpen={false} />
        <AppRouter />
      </QueryClientProvider>
    </MantineProvider>  
    </>
  )
}

export default App

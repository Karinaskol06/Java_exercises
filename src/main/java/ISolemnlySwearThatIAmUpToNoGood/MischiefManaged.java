package ISolemnlySwearThatIAmUpToNoGood;
import java.util.Arrays;
public class MischiefManaged {

    static final double hbar = 1.0;  // Planck's constant
    static final double m = 1.0;     // Mass of particle
    static final int N = 100;        // Number of spatial points
    static final double dx = 0.1;    // Spatial step size
    static final double dt = 0.005;  // Time step size
    static final double[] x = new double[N]; // Spatial grid
    static final double[] V = new double[N]; // Potential

    static Complex[] psi = new Complex[N];   // Wave function at time t
    static Complex[] psiNew = new Complex[N];// Wave function at time t + dt

    // Define the potential (e.g., a harmonic oscillator or a square well)
    static void initializePotential() {
        for (int i = 0; i < N; i++) {
            x[i] = i * dx;
            // Example: Harmonic potential
            V[i] = 0.5 * x[i] * x[i];  // V(x) = 0.5 * x^2
        }
    }

    // Initialize wave function (e.g., a Gaussian packet)
    static void initializeWaveFunction() {
        double x0 = 5.0;  // Initial position of wave packet
        double k0 = 2.0;  // Initial momentum
        double sigma = 1.0;  // Width of the packet

        for (int i = 0; i < N; i++) {
            double expPart = Math.exp(-(x[i] - x0) * (x[i] - x0) / (2 * sigma * sigma));
            double phase = k0 * x[i];
            psi[i] = new Complex(expPart * Math.cos(phase), expPart * Math.sin(phase));
        }
    }

    // Time evolution step using the finite difference method
    static void evolveWaveFunction() {
        for (int i = 1; i < N - 1; i++) {
            // Second derivative (Laplacian) of the wave function
            Complex laplacian = psi[i - 1].minus(psi[i].times(2)).plus(psi[i + 1]);
            // Update using the finite difference scheme
            Complex term = laplacian.times(-0.5 / (dx * dx)).plus(psi[i].times(V[i]));
            psiNew[i] = psi[i].plus(term.times(Complex.I().times(-dt)));
        }
        // Swap psi and psiNew
        System.arraycopy(psiNew, 0, psi, 0, N);
    }

    // Main solver function
    public static void main(String[] args) {
        initializePotential();
        initializeWaveFunction();

        // Evolve for some time steps
        int timeSteps = 1000;
        for (int t = 0; t < timeSteps; t++) {
            evolveWaveFunction();
        }

        // Output the final wave function
        for (int i = 0; i < N; i++) {
            System.out.println(x[i] + " " + psi[i].modulusSquared());
        }
    }


    // Helper class to handle complex numbers
    static class Complex {
        double re;  // Real part
        double im;  // Imaginary part

        Complex(double real, double imag) {
            this.re = real;
            this.im = imag;
        }

        Complex plus(Complex b) {
            return new Complex(this.re + b.re, this.im + b.im);
        }

        Complex minus(Complex b) {
            return new Complex(this.re - b.re, this.im - b.im);
        }

        Complex times(double b) {
            return new Complex(this.re * b, this.im * b);
        }

        Complex times(Complex b) {
            return new Complex(this.re * b.re - this.im * b.im, this.re * b.im + this.im * b.re);
        }

        Complex conjugate() {
            return new Complex(this.re, -this.im);
        }

        static Complex I() {
            return new Complex(0, 1);
        }

        double modulusSquared() {
            return this.re * this.re + this.im * this.im;
        }
    }
}
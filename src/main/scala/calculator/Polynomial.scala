package calculator

object Polynomial {
  def computeDelta(a: Signal[Double], b: Signal[Double],
      c: Signal[Double]): Signal[Double] = {
    Signal(b() * b() - 4 * a() * c())
  }

  def computeSolutions(a: Signal[Double], b: Signal[Double],
      c: Signal[Double], delta: Signal[Double]): Signal[Set[Double]] = {
    Signal {
      delta() match {
        case a if a < 0 => Set()
        case d => Set((-b() + Math.sqrt(d)) / 2 * a(), (-b() - Math.sqrt(d)) / 2 * a())
      }
    }
  }
}

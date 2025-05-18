using Altom.AltTester;
using UnityEngine;

public class AltTesterUnityDriverInitializer : MonoBehaviour
{
    void Start()
    {
        AltRunner runner = new AltRunner();
        runner.Start(new AltStartParameters { 
            host = "0.0.0.0", 
            port = 13000, 
            startAutomatically = true 
        });
    }
}
